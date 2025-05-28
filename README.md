# My_News App
Stay informed with the latest headlines and stories from around the world.
The My_News App is a modern Android news application designed to deliver real-time news updates in a seamless and user-friendly interface. Built with the latest Android development technologies, this app ensures high performance, clean architecture, and responsive design.

---

## Features

-**Real-Time News Feed**: Fetch and display breaking news and trending articles from an integrated news API.

-**Category-Based Browsing**: Explore news by categories like Technology, Sports, Health, Entertainment, and more.

-**Pagination Support**: Smooth and efficient news loading using Paging 3 to handle large datasets.

-**Firebase Integration**: Includes Firebase for backend features such as Authentication, Firestore, or Analytics (as needed).

-**Favorites/Bookmarking**: Save your favorite articles for later reading.

-**Jetpack Compose UI**: Built entirely with Jetpack Compose for a modern, declarative, and maintainable UI design.

-**Dark Mode Support**: Automatically adjusts the theme based on user preference or system settings.

---

## Project Structure

```
app
├── manifests
│   └── AndroidManifest.xml
├── kotlin+java
   |--com.example.my_news
├── data
│   ├── component
│   ├── di
│   ├── local
│   ├── manager
│   ├── remote
│   └── repository
├── domain
│   ├── manager
│   ├── model
│   ├── repository
│   └── usecase
├── presentation
│   ├── bookMarks
│   ├── common
│   ├── Details
│   ├── home
│   ├── Navgraph
│   ├── news_navigator
│   ├── onBoarding
│   ├── search
│   └── Viewmodel
├── MainActivity
└── OnboardingEvent

```
---

## Technologies Used

-**Programming Language**: Kotlin.

-**UI Framework**: Jetpack Compose.

-**Architecture**: MVVM (Model-View-ViewModel).

-**Backend/Services**: Firebase (Authentication, Firestore, etc.).

-**API Integration**: Retrofit.

-**Pagination**: Paging 3 for efficient data loading.

-**Other Libraries**: Coil (for image loading), Hilt (for dependency injection).

---

## Screenshots

3. **Home Screen**
Displays all popular news with search feature .

![image alt](https://github.com/adityamahor/myNews/blob/6cf411c6060c25262b3cb91e500951f09aa8a06e/Screenshot%202025-05-28%20170719.png)

4. **detailed screen**

![image alt](https://github.com/adityamahor/myNews/blob/b121e41447e10e1eac910383fd8aabebcb6d34f6/Screenshot%202025-05-28%20170741.png)

6. **Search screen**
Search any type of news with some keywords.

![image alt](https://github.com/adityamahor/myNews/blob/22643473adc28b4a4d50ae77a503d9cc683089f8/Screenshot%202025-05-28%20170811.png)

7. share any news with our friends and family

![image alt]()

8. Bookmark screen to save your favorite news

![image alt](https://github.com/adityamahor/myNews/blob/9dcf303821c1a74016306799be37fa1055cfb70c/Screenshot%202025-05-28%20170820.png)

---

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/recipe-app.git
   ```
2. Open the project in Android Studio.
3. Sync Gradle.
4. Run the application on an emulator or a physical device.

---

## Contributions

Contributions are welcome! Feel free to fork the repository and submit a pull request.

---

## Contact

For questions or feedback, please reach out at your-email pravesh200525@gmail.com
