# MVVM_NewsApp (Still working on this MD file)

### Description:

This app is implemented with MVVM, it uses `Retrofit` to retrieve and search for news at newsapi.org, and stores favorite news in the database using `Room`. The pagination of the `Recycler View` is 5 articles at a time. The navigation between fragments is built with `Navigation Components`, and a slide-in-and-out animation is added. `Kodein` is used for the dependency injection.
<p align="center"> <img src="/ScreenShots/breakingNews.png" width="200" alt="Breaking News ScreenShot" /> </p>
Click on an item article to view it.
<p align="center"> <img src="/ScreenShots/searchNews.png" width="200" alt="Search News ScreenShot" /> </p>
Type in the search bar to search.
<p align="center"> <img src="/ScreenShots/article.png" width="200" alt="Article ScreenShot" /> </p>
Click on the floating action button to save the article.
<p align="center"> <img src="/ScreenShots/savedNews.png" width="200" alt="Saved News ScreenShot" /> </p>
Swipe left or right to delete the article.

### How to view the project: 

- you can either use my online demo page: https://android-app-demo-page.netlify.app.
(current account status only allow one user at a time, if the load fails or the queue is full, please just wait a bit and refresh the page)
- Or download the MVVM_NewsApp.apk file and install on an android device or a simulator.
- Or clone the project and open it in Android Studio.(I'm re-writing the project, the current version is incomplete, ***so please don't clone it at the moment***)

### Step-by-step project building:

1. Create XML layouts for NewsActivity, BreakingNewsFragment, SearchNewsFragment, SavedNewsFragment using `Recycler View`,
   design the layout for the item article of the list, and the layout for ArticleFragment with `WebView`.
    
2. Setup navigation components:
   - Add dependencies for "androidx.navigation:navigation-fragment-ktx", "androidx.navigation:navigation-ui-ktx".
   - Setup the Host Fragment and all the fragment classes.
   - Design the navigation graph actions and add slide-in-and-out animations.
   - Setup the bottom navigation menu and add the navigation controller to the menu in `NewsActivity`.

3. Retrofit setup:
   - Add dependencies for `Retrofit`: "com.squareup.retrofit2:retrofit", "com.squareup.retrofit2:converter-gson".
   - Add logging interceptor for debugging "com.squareup.okhttp3:logging-interceptor".
   - Create NewsResponse classes from the `JSON` of newsapi.org.
   - Create interface and functions for the NewsAPI according to the documentation of newsapi.org.
   - Create RetrofitInstance class and add the logging interceptor and the converter factory to the instance.

4. Room setup:
   - Add dependencies for `Room`: "androidx.room:room-runtime", "androidx.room:room-ktx", kapt "androidx.room:room-compiler".
   - Annotate Article data class, and create ArticleDao interface.
   - Create ArticleDatabase class.
   - Create Converters class for the `TypeConverters` for Source data class, and add it to ArticleDatabase.

5. Setup RecyclerView with DiffUtil:
   - Add dependencies for `Glide`: "com.github.bumptech.glide:glide", kapt "com.github.bumptech.glide:compiler".
   - Create NewsAdapter class with binding, AsyncListDiffer, Glide.
   - Add onItemClickListener to the binding via a setter function.

6. Setup the MVVM architectural skeleton:
   - Add dependencies for `LifeCycle`: "androidx.lifecycle:lifecycle-viewmodel-ktx", "androidx.lifecycle:lifecycle-runtime-ktx".
   - Create NewsRepository class with ArticleDatabase, NewsAPI.
   - Create NewsViewModel, NewsViewModelProviderFactory class.
   - Instantiate repository, viewModelProviderFactory, ViewModel in NewsActivity
   - Setup binding and viewModel in all the fragment classes
   - Create a wrapper generic Resource class to wrap around the responses.

7. Handling breaking news response:
   - Add `user-permissions` for the Internet in manifest
   - Add dependencies for `Coroutines`: "org.jetbrains.kotlinx:kotlinx-coroutines-core", "org.jetbrains.kotlinx:kotlinx-coroutines-android".
   - Create getBreakingNews function in NewsRepository
   - Create a function to launch `getBreakingNews()`, and a function to handle the response.
   - setup RecyclerView with `breakingNews` LiveData in BreakingNewsFragment
   - Handle the different return types of Resource<NewsResponse> 