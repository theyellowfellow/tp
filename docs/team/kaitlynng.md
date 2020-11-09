---
layout: page
title: Kaitlyn Ng's Project Portfolio Page
---

## Project: Baymax

Baymax is a desktop appointment book application that helps small clinics manage patient and appointment information. The user interacts with it using a CLI, and it has a GUI created with JavaFX. It is written in Java, and has about 13 kLoC. This document records my contributions to the project, and the github page of the project can be found here: ttps://ay2021s1-cs2103t-w12-3.github.io/tp/

Given below are my contributions to the project.

* **New Feature**: Schedule View
  * What it does: allows the user to visualise all the appointments that booked in a single day, displayed chronologically using a timeline. 
  * Justification: This feature allows the user to get a quick overview of the appointments they have on a particular day, so that they can more easily recommend available appointment dates to patients and organise their time during the day to accommodate for all the appointments.
  * Highlights: This feature takes advantage of the new JavaBeans class design to create dynamically updated data views with clean and simple code architecture. 
  * Credits: Inspiration was taken from the CalendarFX project, that implements calendar functionality into JavaFX.

* **New Feature**: Added backend functionality for handling appointments in the Model and Storage components to allow for Appointment commands
  * What it does: provides the backend needed for front-end functionality of CRUD oeprations on appointments. 
  * Justification: This feature is key to the functionalities of Baymax as a clinic management application, as it is essential for Baymax to be able to perform CRUD operations on appointments.
  * Highlights: This feature required a re-design of the backend implementation of all the list managers (for patients and appointments, the two main data types Baymax handles) to using generic classes for a more streamlined architecture. Design considerations had to be made to establish the parent-child relationship between patients and appointments, and to ensure that all the data objects are json serializable for storage.
  
* **New Feature**: Advanced DateTime and Calendar date functionalities
  * What it does: Provided backend abstraction of more advanced DateTime operations for Calendar and Schedule view into a DateTime utilities package to automatically support operations like accounting for leap years.
  * Justification: Simplifies the code base such that low-level implementation details can be hidden, making the high-level code base more readable and friendly to work with.
 

* **Code contributed**: [RepoSense link](https://nus-cs2103-ay2021s1.github.io/tp-dashboard/#breakdown=true&search=kaitlynng&sort=totalCommits&sortWithin=title&since=2020-08-14&until=2020-11-09&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other)

* **Enhancements to existing features**:
  * Streamlined implementation of Date fpr Calendar components (Pull requests [\#284](https://github.com/AY2021S1-CS2103T-W12-3/tp/pull/284))
  * Improved view experience for application UI (Pull requests [\#284](https://github.com/AY2021S1-CS2103T-W12-3/tp/pull/284), [\#266](https://github.com/AY2021S1-CS2103T-W12-3/tp/pull/266))
  * Wrote additional tests for existing features (Pull requests [\#284](https://github.com/AY2021S1-CS2103T-W12-3/tp/pull/284)), [\#266](https://github.com/AY2021S1-CS2103T-W12-3/tp/pull/266))

* **Documentation**:
My contributions to the User Guide and Developer Guide can be viewed below.

User Guide:
(https://github.com/AY2021S1-CS2103T-W12-3/tp/blob/master/docs/UserGuide.md)
Developer Guide:
(https://github.com/AY2021S1-CS2103T-W12-3/tp/blob/master/docs/DeveloperGuide.md)

* **Community**:
  * PRs reviewed (with non-trivial review comments): [\#86](https://github.com/AY2021S1-CS2103T-W12-3/tp/pull/86), [\#176](https://github.com/AY2021S1-CS2103T-W12-3/tp/pull/176), [\#297](https://github.com/AY2021S1-CS2103T-W12-3/tp/pull/297)
  * Some parts of the backend implementation using generic classes I implemented was adopted by another group 

