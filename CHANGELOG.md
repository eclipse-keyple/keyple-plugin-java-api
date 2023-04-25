# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]
### Added
- `CHANGELOG.md` file (issue [eclipse/keyple#6]).
- CI: Forbid the publication of a version already released (issue [#7]).
- The method `PoolPluginSpi.allocateReader` now returns the new interface `PoolReaderSpi`, which extends `ReaderSpi`, in
  order to retrieve the smart card that may be automatically selected.

## [2.0.0] - 2021-10-06
This is the initial release.
It follows the extraction of Keyple 1.0 components contained in the `eclipse/keyple-java` repository to dedicated repositories.
It also brings many major API changes.

[unreleased]: https://github.com/eclipse/keyple-plugin-java-api/compare/2.0.0...HEAD
[2.0.0]: https://github.com/eclipse/keyple-plugin-java-api/releases/tag/2.0.0

[#7]: https://github.com/eclipse/keyple-plugin-java-api/issues/7

[eclipse/keyple#6]: https://github.com/eclipse/keyple/issues/6