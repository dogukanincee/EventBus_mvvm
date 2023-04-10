# Eventbus MVVM Implementation

This is a sample Android app that demonstrates how to use the EventBus library with the MVVM architecture pattern. 
The app allows the user to post a message, which is then displayed in a TextView using LiveData and ViewModel.

-----
Setup
-----
To run the app, you will need to have Android Studio installed. Clone this repository and open the project in Android Studio.

-----
Libraries
-----
The following libraries are used in this app:

EventBus - An event bus for Android that simplifies communication between components.
LiveData - A data holder class that can be observed for changes.
ViewModel - A class that is responsible for preparing and managing the data for an activity or fragment.
Kotlin Coroutines - A concurrency library for Kotlin that simplifies asynchronous programming.

-----
Architecture
------
The app uses the MVVM (Model-View-ViewModel) architecture pattern. 
The data is stored in the ViewModel, and the UI is updated using LiveData. The EventBus library is used to communicate between the ViewModel and the UI.
