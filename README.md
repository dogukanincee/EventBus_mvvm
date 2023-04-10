# Eventbus MVVM Implementation

The EventBus-MVVM Sample App is an Android application that demonstrates how to use the EventBus library with the MVVM architecture pattern. 
The app allows the user to post a message, which is then displayed in a TextView using LiveData and ViewModel.

-----
Setup
-----
To run the app, you will need to have Android Studio installed. Clone this repository and open the project in Android Studio.

-----
Libraries
-----

The app uses the following libraries:

- EventBus: An event bus for Android that simplifies communication between components. 
EventBus allows you to send events from one part of your app to another, without having to worry about the details of how the events are sent and received.

- LiveData: A data holder class that can be observed for changes. LiveData is part of the Android Architecture Components, and is designed to help you build apps that are lifecycle-aware and reactive.

- ViewModel: A class that is responsible for preparing and managing the data for an activity or fragment. ViewModel is part of the Android Architecture Components, and is designed to help you separate your UI logic from your data.

- Kotlin Coroutines: A concurrency library for Kotlin that simplifies asynchronous programming. Coroutines allow you to write asynchronous code in a sequential and natural way, making it easier to reason about and debug.

-----
Architecture
------
The app uses the MVVM (Model-View-ViewModel) architecture pattern. This pattern separates the UI (View) from the data (Model) and the logic (ViewModel) that operates on the data. The ViewModel holds the data and is responsible for preparing and managing it for the UI. The UI observes the data through LiveData, and updates itself whenever the data changes.

The app also uses the EventBus library to communicate between the ViewModel and the UI. EventBus is an event bus for Android that simplifies communication between components. With EventBus, you can easily send events from one part of your app to another, without having to worry about the details of how the events are sent and received.


-----
Conclusion
-----
The EventBus-MVVM Sample App demonstrates how to use the EventBus library with the MVVM architecture pattern in an Android app. By separating the UI, data, and logic, you can create apps that are easier to maintain and test. EventBus simplifies communication between components, making it easier to send and receive events within your app. By using LiveData and ViewModel, you can create apps that are lifecycle-aware and reactive, making it easier to manage state and update the UI.
