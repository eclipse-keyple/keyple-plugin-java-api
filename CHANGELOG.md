# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]
### Changed
- Migrated the CI pipeline from Jenkins to GitHub Actions.

## [2.3.2] - 2025-04-18
### Changed
- Switched license from `EPL 2.0` to `MIT` (issue [#16]).
  The license switch has been authorized through a restructuring review supervised by the « Eclipse Management
  Organization » team https://gitlab.eclipse.org/eclipsefdn/emo-team/emo/-/issues/908#note_3394156.

## [2.3.1] - 2024-04-12
### Changed
- Java source and target levels `1.6` -> `1.8`
### Upgraded
- Gradle `6.8.3` -> `7.6.4`

## [2.3.0] - 2024-03-29
### Added
- `CardPresenceMonitorBlockingSpi` as a replacement of the deprecated `WaitForCardRemovalDuringProcessingBlockingSpi` 
  interface.

## [2.2.0] - 2023-11-13
### Fixed
- CI: code coverage report when releasing.
### Added
- CI: added project status badges on `README.md` file.
- Added precisions to Javadoc of `openPhysicalChannel()`, `closePhysicalChannel()` and `checkCardPresence()` methods of 
  the `ReaderSpi` interface.
- `CardInsertionWaiterAsynchronousApi` (renaming)
- `CardRemovalWaiterAsynchronousApi` (renaming)
- `CardInsertionWaiterAsynchronousSpi` (renaming)
- `CardInsertionWaiterBlockingSpi` (renaming)
- `CardInsertionWaiterNonBlockingSpi` (renaming and adds the capability to customize the polling cycle duration)
- `CardRemovalWaiterAsynchronousSpi` (renaming)
- `CardRemovalWaiterBlockingSpi` (renaming)
- `CardRemovalWaiterNonBlockingSpi` (renaming and adds the capability to customize the polling cycle duration)
- `AutonomousObservablePluginSpi.setCallback(...)` (renaming)
### Deprecated
- `WaitForCardInsertionAutonomousReaderApi` (replaced by `CardInsertionWaiterAsynchronousApi`)
- `WaitForCardRemovalAutonomousReaderApi` (replaced by `CardRemovalWaiterAsynchronousApi`)
- `WaitForCardInsertionAutonomousSpi` (replaced by `CardInsertionWaiterAsynchronousSpi`)
- `WaitForCardInsertionBlockingSpi` (replaced by `CardInsertionWaiterBlockingSpi`)
- `WaitForCardInsertionNonBlockingSpi` (replaced by `CardInsertionWaiterNonBlockingSpi`)
- `DontWaitForCardRemovalDuringProcessingSpi` (no more used)
- `WaitForCardRemovalDuringProcessingBlockingSpi` (no more used)
- `WaitForCardRemovalAutonomousSpi` (replaced by `CardRemovalWaiterAsynchronousSpi`)
- `WaitForCardRemovalBlockingSpi` (replaced by `CardRemovalWaiterBlockingSpi`)
- `WaitForCardRemovalNonBlockingSpi` (replaced by `CardRemovalWaiterNonBlockingSpi`)
- `AutonomousObservablePluginSpi.connect(...)` (replaced by `setCallback(...)`)

## [2.1.0] - 2023-04-25
### Added
- The method `PoolPluginSpi.allocateReader` now returns the new interface `PoolReaderSpi`, which extends `ReaderSpi`, in
  order to retrieve the smart card that may be automatically selected.
- `CHANGELOG.md` file (issue [eclipse-keyple/keyple#6]).
- CI: Forbid the publication of a version already released (issue [#7]).

## [2.0.0] - 2021-10-06
This is the initial release.
It follows the extraction of Keyple 1.0 components contained in the `eclipse-keyple/keyple-java` repository to dedicated repositories.
It also brings many major API changes.

[unreleased]: https://github.com/eclipse-keyple/keyple-plugin-java-api/compare/2.3.2...HEAD
[2.3.2]: https://github.com/eclipse-keyple/keyple-plugin-java-api/compare/2.3.1...2.3.2
[2.3.1]: https://github.com/eclipse-keyple/keyple-plugin-java-api/compare/2.3.0...2.3.1
[2.3.0]: https://github.com/eclipse-keyple/keyple-plugin-java-api/compare/2.2.0...2.3.0
[2.2.0]: https://github.com/eclipse-keyple/keyple-plugin-java-api/compare/2.1.0...2.2.0
[2.1.0]: https://github.com/eclipse-keyple/keyple-plugin-java-api/compare/2.0.0...2.1.0
[2.0.0]: https://github.com/eclipse-keyple/keyple-plugin-java-api/releases/tag/2.0.0

[#16]: https://github.com/eclipse-keyple/keyple-plugin-java-api/issues/16
[#7]: https://github.com/eclipse-keyple/keyple-plugin-java-api/issues/7

[eclipse-keyple/keyple#6]: https://github.com/eclipse-keyple/keyple/issues/6