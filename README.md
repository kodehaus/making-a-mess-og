"# bonfireEvents" 
Engineering for Agility - Java

Sample code for the "Engineering for Agility" workshop. It documents a test- and domain-driven (TDD & DDD) journey toward a microservice for a sample system we call "Bonfire Events," essentially a meetup.com clone. Stories for this exercise are tracked in GitHub issues. There is also a Story & Journey map on Mural that gives some insight into the overall user experience.
The codebase is built with Java 11 and has been verified to run in Intellij

Installing Dependencies
From the repository root directory, in a terminal, type: gradle build

Running Tests

//TODO fix
For JetBrains rider (what instructors are likely to use), the in-built test runner "just works."
For Visual Studio Code (using the terminal window) and the generally terminal obsessed, you can change directory into any of the projects and use the dotnet command:
$ dotnet test
If you want to run the actual API through a test web server, say for exploratory testing purposes, the following command will do the trick:
$ dotnet run --project BonfireEvents.Api
This should open a browser at the configured API location https://localhost:5000/event.
//END TODO


Navigating the Exercises
Navigating exercies is based on git branches. In the workshop you'll be presented with challenges in the form of user stories. These stories are designed to be completed in order. To get started:
git checkout tags/start -b {YOUR_BRANCH_NAME}
Note: you may need to pull tags from the remote. To do this: git fetch --all --tags
Users can switch to a known-good checkpoint by similarly branching off on tags that indicate completion of one of the workshop stories. For example, git checkout tags/S04 -b {YOUR_BRANCH_NAME} will create a new branch where S04 is in a solved state (solved by instructor).
There are a few use cases where this could come in handy:

This helps student stay up-to-date with the class's pace and gives them a chance to view how the instructor solved the problem.
If they like the instructor's solution better, the student is able to continue on to User Story 4 (tagged: S04) from that point.
Instructors may recommend students realign to a known-good state.