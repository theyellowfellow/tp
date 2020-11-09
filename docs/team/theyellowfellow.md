---
layout: page
title: Reuben Teng's Project Portfolio Page
---

## Project: Baymax

Baymax is a desktop patient management application used for managing patients and appointments in clinics. The user interacts with it using a CLI, and it has a GUI created with JavaFX. It is written in Java, and has about 13 kLoC.

Given below are my contributions to the project.

* **New Package**: Added the relevant classes for appointments.
  * What it does: Sets up basis for features to be added regarding appointment management.
  * Justification: The foundation for appointments allowed for one of the main features of our application, the management of patient appointments.
  * Credits: AB3 (Similar implementation to how AB3 implements management of people and addresses)

* **Test**: Covered tests for model.appointment and util.datetime packages
  * What it does: Ensures that appointments and datetime related functions work properly.
  * Justification: Being vital to the operations of our application, it was important to heavily test the classes within appointment and datetime packages to ensure proper functionality.

* **Bug Fix**: Prevented multiple command parameters from being accepted.
  * What it does: As mentioned in [Issue \#247](https://github.com/AY2021S1-CS2103T-W12-3/tp/issues/247), the bug allowed for multiple parameters (e.g. name/) to be entered, with the application running on the last one entered. Fixing this allowed the app to alert users when a parameter was used more than once (except tag/, since multiple tags are allowed).
  * Justification: As a Healthcare related application, it is natural for there to be large amounts of information attached to each patient. As such, we should anticipate for mistakes in the entering of fields as much as possible, including typing the same parameter multiple times by accident, or even typing the wrong parameter name.
  
* **Code contributed**: [RepoSense link](https://nus-cs2103-ay2021s1.github.io/tp-dashboard/#breakdown=true&search=&sort=groupTitle&sortWithin=title&since=2020-08-14&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other&tabOpen=true&tabType=authorship&tabAuthor=theyellowfellow&tabRepo=AY2021S1-CS2103T-W12-3%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code&authorshipSortBy=lineOfCode)

* **Documentation**:
  * User Guide:
    * Managed tone of UG [\#158](https://github.com/AY2021S1-CS2103T-W12-3/tp/pull/158)
    * Added documentation for the modified/added features such as `remark` and `cancel` [\#185](https://github.com/AY2021S1-CS2103T-W12-3/tp/pull/185)
    * Did cosmetic tweaks to existing documentation of many features (adding of relevant pictures) [\#185](https://github.com/AY2021S1-CS2103T-W12-3/tp/pull/185)
  * Developer Guide:
    * Removed references linking to AB3 and replaced to links to our own repository [\#298](https://github.com/AY2021S1-CS2103T-W12-3/tp/pull/298)
    * Added UML class diagrams for Storage and Model, and a sequence diagram for a sample command [\#139](https://github.com/AY2021S1-CS2103T-W12-3/tp/pull/139)
    * Added and updated Glossary [\#75](https://github.com/AY2021S1-CS2103T-W12-3/tp/pull/75) and
    * Updated Design details of Model with Kaitlyn [\#297](https://github.com/AY2021S1-CS2103T-W12-3/tp/pull/297)
    * Updated Implementation details of Appointment Management (Design Considerations) [\#297](https://github.com/AY2021S1-CS2103T-W12-3/tp/pull/297)

* **Community**:
  * PRs reviewed (with non-trivial review comments): [\#256](https://github.com/AY2021S1-CS2103T-W12-3/tp/pull/256), [\#299](https://github.com/AY2021S1-CS2103T-W12-3/tp/pull/299), [\#300](https://github.com/AY2021S1-CS2103T-W12-3/tp/pull/300)
  * Reported bugs and suggestions for other teams in the class (examples: [1](https://github.com/theyellowfellow/ped/issues/1), [2](https://github.com/theyellowfellow/ped/issues/9), [3](https://github.com/theyellowfellow/ped/issues/3))

