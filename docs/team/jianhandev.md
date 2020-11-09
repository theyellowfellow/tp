---
layout: page
title: Li Jianhan's Project Portfolio Page
---

## Project: Baymax

Baymax is a desktop appointment book application that helps small clinics manage patient and appointment information. The user interacts with it using a CLI, and it has a GUI created with JavaFX. It is written in Java, and has about 13 kLoC.

Given below are my contributions to the project.

* **New Feature**: Appointment Calendar
  * What it does: allows the user to visualise date and time, coupled with a schedule view which displays appointments chronologically on a timeline.
  * Justification: This feature improves the user's experience as they can hop between different dates inside the Calendar view, and zoom into a particular day for all the appointments on that day using a single command.
  * Highlights: This enhancement revolutionizes the way dates are handled in our CLI application. For example, with the use of the calendar, the user can add appointments to a day without having to enter the date itself since it has been captured by the Calendar. This shortens commands and quickens the process of appointment scheduling.
  It required an in-depth analysis of design alternatives. The implementation too was challenging as it required the implementation of an entirely new Calendar Manager that is very different from the traditionally used List Managers.

* **New Feature**: Added an add appointment by patient NRIC command that allows the user to add appointments not just by index, but also patient's NRIC.
    * Justification: This feature allows adding of appointments directly to a patient using a single line of command, without having to find the patient beforehand by listing out.
    * Highlights: This enhancement required a re-design of the Parser logic to be able to differentiate between the different modes of add appointment operations. A similar approach is later adapted by other commands for greater flexibility.

* **New Feature**: Dashboard for keeping track of appointments on the current day.
    * Justification: This feature allows the user to view all appointments on the current day without any additional effort. This improves user experience and makes the job of the receptionist much easier.
 
* **Code contributed**: [RepoSense link](https://nus-cs2103-ay2021s1.github.io/tp-dashboard/#search=jianhandev&sort=groupTitle&sortWithin=title&since=2020-08-14&until=2020-11-09&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=false&tabOpen=true&tabType=authorship&tabAuthor=jianhandev&tabRepo=AY2021S1-CS2103T-W12-3%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code~other)

* **Project management**:
  * Managed releases `v1.1` - `v1.4` (4 releases) on GitHub

* **Enhancements to existing features**:
  * Updated the GUI color scheme (Pull requests [\#86](https://github.com/AY2021S1-CS2103T-W12-3/tp/pull/86))
  * Wrote additional tests for existing features to increase coverage (Pull requests [\#274](https://github.com/AY2021S1-CS2103T-W12-3/tp/pull/274))

* **Documentation**:<br>
My contributions to the User Guide and Developer Guide can be viewed below.
  * User Guide:
    * (https://github.com/AY2021S1-CS2103T-W12-3/tp/blob/master/docs/UserGuide.md)
  * Developer Guide:
    * (https://github.com/AY2021S1-CS2103T-W12-3/tp/blob/master/docs/DeveloperGuide.md)
