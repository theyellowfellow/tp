---
layout: page
title: Shi Hui Ling's Project Portfolio Page
---

## Project: Baymax

Baymax is a desktop appointment book application that helps small clinics manage patient and appointment information. The user interacts with it using a CLI, and it has a GUI created with JavaFX. It is written in Java, and has about 13 kLoC.

Given below are my contributions to the project.

* **New Feature**: Added the ability to delete an appointment
  * [\#159](https://github.com/AY2021S1-CS2103T-W12-3/tp/pull/159)
  * What it does: allows the user to delete an appointment based on its `Index` in the displayed appointment list, or 
  based on a `DateTime` and a patient specified. 
  * Justification: This is a basic feature of a CRUD application such as Baymax. Users should be able to delete appointments
  for cases where a patient cancels an appointment.
  * Highlights: The implementation of this was very challenging as it required first figuring out / setting up the functionalities for finding an appointment by its matching `DateTime` and `Patient`,
  and finding a `Patient` by a supplied `Name` or `Nric` (originally -- this was reduced to just `Name` to simplify the command). 
  These required adding new `Predicate` classes and new methods in `AppointmentManager` and `ModelManager`, as well as making use of existing methods in `UniqueList` (such as `getByPredicate`). These were helpful for commands added in the future.

* **New Feature**: Added the ability to find appointment(s) by keywords matching their remark or tags
  * [\#175](https://github.com/AY2021S1-CS2103T-W12-3/tp/pull/175)
  * What it does: allows the user to enter a search string and obtain a list of appointments that contain the
  search string in their remark or tag fields
  * Justification: This feature allows logical filtering of appointments of a certain "type", e.g. blood tests, X-rays, 
  even appointments belonging to a certain doctor. 
  * Highlights: this required understanding and making use of methods in `StringUtil` and streams used in `UniqueList`

* **New Feature**: Added the ability to mark appointments as missed and done
  * [\#172](https://github.com/AY2021S1-CS2103T-W12-3/tp/pull/172) [\#186](https://github.com/AY2021S1-CS2103T-W12-3/tp/pull/186)
  * What it does: allows the user to change the status of an appointment to `MISSED` or `DONE`.
  * Justification: This feature is important as it allows users to keep track of past appointments that were missed (the default is `DONE`), and to
  correct appointments that were accidentally marked as `MISSED`
  
* **Enhancement to New Feature**: Added functionality to `listapptsof` Command to take in `name` and `nric` as additional ways to specify the patient 
  * [\#167](https://github.com/AY2021S1-CS2103T-W12-3/tp/issues/167) 
  * What it does: allows user to specify the patient whose appointments they want to view by supplying either `name` or `nric` in addition to `index` in the displayed patient list
  * Justification: This is so that users do not have to navigate to a displayed patient list everytime they want to use the `listapptsof` Command, 
  as it is quite likely that they can remember the name of the `Patient` they're looking for

* **Code contributed**: [RepoSense link](https://nus-cs2103-ay2021s1.github.io/tp-dashboard/#breakdown=true&search=porkeypine&sort=groupTitle&sortWithin=title&since=2020-08-14&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other&until=2020-11-09)

* **Bugs fixed**:
  * Fixed bugs from Practical Exam Dry Run: not deleting appointments of a patient when the patient is deleted, 
  and many bugs pertaining to wrong error s displayed [\#256](https://github.com/AY2021S1-CS2103T-W12-3/tp/pull/256)
  * Fixed UI bugs pertaining to wrong error messages displayed (exceptions not thrown properly) [\#186](https://github.com/AY2021S1-CS2103T-W12-3/tp/pull/186) [\#301](https://github.com/AY2021S1-CS2103T-W12-3/tp/pull/301)
  * Performed manual testing to find bugs

* **Enhancements to existing features**:
  * Wrote additional tests for Appointment Command package, and edited a few other tests and testutils as well [\#283](https://github.com/AY2021S1-CS2103T-W12-3/tp/pull/283)
  
* **Documentation**:
  * User Guide:
    * Added documentation for the GUI terminology, command format and syntax [\#165](https://github.com/AY2021S1-CS2103T-W12-3/tp/pull/165)
    * Added documentation for parameters of commands [\#165](https://github.com/AY2021S1-CS2103T-W12-3/tp/pull/165)
    * Added documentation for command summary section [\#165](https://github.com/AY2021S1-CS2103T-W12-3/tp/pull/165)
    * Did cosmetic tweaks to various headings, numberings etc. [\#165](https://github.com/AY2021S1-CS2103T-W12-3/tp/pull/165)
    * Reviewed and updated UG to correctly reflect commands and features [\#256](https://github.com/AY2021S1-CS2103T-W12-3/tp/pull/256)
  * Developer Guide:
    * Added some design considerations for `Appointment Management sections` [\#304](https://github.com/AY2021S1-CS2103T-W12-3/tp/pull/304)
    * Reviewed diagrams for and edited `Logic` component and `Appointment Management` sections [\#304](https://github.com/AY2021S1-CS2103T-W12-3/tp/pull/304)
    * Updated user stories and added use cases [\#301](https://github.com/AY2021S1-CS2103T-W12-3/tp/pull/301)
    * Updated non-functional requirements [\#72](https://github.com/AY2021S1-CS2103T-W12-3/tp/pull/72)

* **Community**:
  * PRs reviewed (with non-trivial review comments): [\#12](), [\#32](), [\#19](), [\#42]()
  * Reported bugs and suggestions for other teams in the class (examples: [1](https://github.com/porkeypine/ped/issues), [2](https://drive.google.com/file/d/1PqSNtGZ1Yg7nvwzNkairLj45LeqZx0yK/view?usp=sharing))
