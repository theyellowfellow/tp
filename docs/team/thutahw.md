---
layout: page
title: Thuta Htun Wai's Project Portfolio Page
---

## Project: Baymax

Baymax is a desktop application used by the clinic receptionists to manage patient and appointment information. The user interacts with it using a CLI, and it has a GUI created with JavaFX. It is written in Java, and has about 13 kLoC.

Given below are my contributions to the project.

* **New Feature**: Added the basic patient information management features and the tests.

  * What it does:  These features allow the user to add, delete, edit, find and list all the patients in the system. 
  * Justification: These features are the core of a typical clinic patient and appointment application as they alllow the user to perform basic functionalities such as adding and deleting patients.
  * Highlights: These features are necessary in order to perform other features such as the appointment management features. 
  It was challenging to add new fields such as `gender` for the patient as it required modifying a huge part of the original code.
  * Credits: Adapted Address Book Level-3's person package for the patient model. 
  
* **New Feature**: Added the `listapptsof` feature (`listapptsof INDEX`). 

  * What it does: It allows the user to list all the appointments belonging to a specific patient by using his/her index in the patient list.
  * Justification: This feature is important for a clinic receptionists to instantly view a specific patient's appointments so that he/she can find out when to schedule the next appointment.
  * Highlights: This feature required coming up with a specific predicate to filter the patient list in order to put the right patients inside the displayed list.
  * Credits: 
  
* **Code contributed**: [RepoSense link](https://nus-cs2103-ay2021s1.github.io/tp-dashboard/#breakdown=true&search=&sort=groupTitle&sortWithin=title&since=2020-08-14&until=2020-11-09&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other&tabOpen=true&tabType=authorship&tabAuthor=thutahw&tabRepo=AY2021S1-CS2103T-W12-3%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code)

* **Enhancements to existing features**:

  * Wrote additional tests for existing features to increase coverage (Pull requests [\#90](https://github.com/AY2021S1-CS2103T-W12-3/tp/pull/90/files), [\#97](https://github.com/AY2021S1-CS2103T-W12-3/tp/pull/97), 
  [\#131](https://github.com/AY2021S1-CS2103T-W12-3/tp/pull/131), [\#170](https://github.com/AY2021S1-CS2103T-W12-3/tp/pull/170), 
  [\#182](https://github.com/AY2021S1-CS2103T-W12-3/tp/pull/182), [\#190](https://github.com/AY2021S1-CS2103T-W12-3/tp/pull/190))

* **Community**:

  * PRs reviewed (with non-trivial review comments): [\#111](https://github.com/AY2021S1-CS2103T-W12-3/tp/pull/111),
   [\#271](https://github.com/AY2021S1-CS2103T-W12-3/tp/pull/271), [#299](https://github.com/AY2021S1-CS2103T-W12-3/tp/pull/299)
    
  * Tested our own app and reported the bugs found (examples: [1](https://github.com/AY2021S1-CS2103T-W12-3/tp/issues/155),
   [2](https://github.com/AY2021S1-CS2103T-W12-3/tp/issues/178),
   [3](https://github.com/AY2021S1-CS2103T-W12-3/tp/issues/179),
   [4](https://github.com/AY2021S1-CS2103T-W12-3/tp/issues/180),
   [5](https://github.com/AY2021S1-CS2103T-W12-3/tp/issues/181))  

  * Reported bugs and suggestions for other teams in the class (examples: [1](https://github.com/thutahw/ped/issues/1),
   [2](https://github.com/thutahw/ped/issues/3), [3](https://github.com/thutahw/ped/issues/4))

* **Documentation**:

  * User Guide:
    * Added the explanation sections under the Patient Features, and the Appointment Features.
    * Added the screenshots for the features.
    
  * Developer Guide:
    * Added implementation details of the `Patient Management Features` .
    * Added the activity diagram and sequence diagram for the `FindPatientCommand`.
    * Updated the Product Scope.


