PROJECT_DIR := $(dir $(abspath $(lastword $(MAKEFILE_LIST))))
TARGET_DIR=$(PROJECT_DIR)target

CI_BUILD_NUMBER ?= $(USER)-SNAPSHOT
CI_IVY_CACHE ?= $(HOME)/.ivy2
CI_SBT_CACHE ?= $(HOME)/.sbt
CI_WORKDIR ?= $(shell pwd)

VERSION ?= 0.1.$(CI_BUILD_NUMBER)

BUILDER_TAG = "mup.cr/blt/build-sbt:78"

package-sbt:
	sbt clean \
		"set coverageEnabled := true" \
		"set coverageOutputHTML := false" \
		test \
		coverageReport \
		coverallsMaybe \
		coverageOff

# We clean the locally cached version
# of the jar when we're done publishing.
publish-sbt: package-sbt
	sbt publish

publish:
	docker run \
		--rm \
		-v $(CI_WORKDIR):/data \
		-v $(CI_IVY_CACHE):/root/.ivy2 \
		-v $(CI_SBT_CACHE):/root/.sbt \
		-v $(HOME)/.bintray:/root/.bintray \
		-e VERSION=$(VERSION) \
		-e COVERALLS_REPO_TOKEN=$(COVERALLS_REPO_TOKEN) \
		-e TRAVIS_JOB_ID=$(TRAVIS_JOB_ID) \
		$(BUILDER_TAG) \
		publish-sbt

package:
	docker run \
		--rm \
		-v $(CI_WORKDIR):/data \
		-v $(CI_IVY_CACHE):/root/.ivy2 \
		-v $(CI_SBT_CACHE):/root/.sbt \
		-v $(HOME)/.bintray:/root/.bintray \
		-e VERSION=$(VERSION) \
		-e COVERALLS_REPO_TOKEN=$(COVERALLS_REPO_TOKEN) \
		-e TRAVIS_JOB_ID=$(TRAVIS_JOB_ID) \
		$(BUILDER_TAG) \
		package-sbt

# Required for SBT.
version:
	@echo $(VERSION)
