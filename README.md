# MVVM_NewsApp

### Description:
***IMPORTANT***: The newsapi.org free plan only allows 100 queries per day, when used up this app will not work.
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
- Or clone the project and open it in Android Studio.

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
   - Add `user-permissions` for the Internet in manifest.
   - Add dependencies for `Coroutines`: "org.jetbrains.kotlinx:kotlinx-coroutines-core", "org.jetbrains.kotlinx:kotlinx-coroutines-android".
   - Create getBreakingNews function in NewsRepository.
   - Create a function to launch `getBreakingNews()`, and a function to handle the response in NewsViewModel.
   - Setup RecyclerView with `breakingNews LiveData` in BreakingNewsFragment.
   - Handle the different types of `Resource<NewsResponse>` .

8. Handling search news response:
   - Setup NewsRepository, NewsViewModel, and SearchNewsFragment, the same way as for the breaking news.
   - Implement `addTextChangedListener` for the `EditText` with `Coroutine Job` to search for news with a time delay.

9. Show articles in the WebView:
   - Add plugin: `id "androidx.navigation.safeargs.kotlin" version "2.5.1"`
   - Make Article class serializable and add it to the argument of ArticleFragment in the navigation graph.
   - In all fragments, implement `setOnItemClickListener` with the corresponding navigation action.
   - get the article from ArticleFragmentArgs and pass it to the WebView

10. Adding and deleting articles in the database:
   - Implement all the ArticleDao functions to NewsRepository and NewsViewModel.
   - Call those functions in ArticleFragment and SavedNewsFragment
   - Implement the swipe to delete functionality by creating an `itemTouchHelperCallback` and attaching it to the `RecyclerView`.

11. Handling pagination:
   - Update the handle response functions to add new articles to the old articles.
   - Implement a scrollListener to load a new page when needed in the fragments (always cast to List for DiffUtil)
   - In SearchNewsFragment, clear LiveData and SearchNewsResponse when EditText changes.

12. Handling Internet connection exceptions:
   - Create NewsApplication class, add it to the manifest, and pass it to AndroidViewModel.
   - Get the connectivityManager from the application context, and detect the connectivity base on different versions.
   - Create safe calls for `getbreakingNews()` and `searchNews()`.
   - Add the application parameter to all necessary classes.

13. Handling dependency injection:
   - Add Kodein dependencies: "org.kodein.di:kodein-di-generic-jvm", "org.kodein.di:kodein-di-framework-android-x".
   - Instantiate database, repository, factory in NewsApplication.
   - Replace the instantiation in the activity class with Kodein.