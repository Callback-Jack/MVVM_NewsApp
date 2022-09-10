# MVVM_NewsApp (Still working on this MD file)

### Description:

This app is implemented with MVVM, it uses `Retrofit` to retrieve and search for news at newsapi.org, and stores favorite news in the database using `Room`. The pagination of the `Recycler View` is 5 articles at a time. The navigation between fragments is built with `Navigation Components`, and a slide-in-and-out animation is added.
<p align="center"> <img src="/ScreenShots/breakingNews.png" width="200" alt="Breaking News SceenShot" /> </p>
Click on a item artilce to view it.

<p align="center"> <img src="/ScreenShots/searchNews.png" width="200" alt="Search News SceenShot" /> </p>
Type in the search bar to search.
<p align="center"> <img src="/ScreenShots/article.png" width="200" alt="Article SceenShot" /> </p>
Click on the floating action button to save the article.
<p align="center"> <img src="/ScreenShots/savedNews.png" width="200" alt="Saved News SceenShot" /> </p>
Swipe left or right to delete the article.

### How to view the project: 

- you can either use my online demo page: https://android-app-demo-page.netlify.app.
(current account status only allow one user at a time, if the load fails or the queue is full, please just wait a bit and refresh the page)
- Or download the MVVM_NewsApp.apk file and install on an android device or a simulator.
- Or clone the project and open it in Android Studio.(I'm re-writing the project, the current version is incomplete, ***so please don't clone it at the moment***)

### Step-by-step project building:

1. Create XML layouts for NewsActivity, BreakingNewsFragment, SearchNewsFragment, SavedNewsFragment using `Recycler View`,
   design the layout for the item article of the list, and the layout for ArticleFragment with `WebView`.
    
2. 

