## BindAdapters [![](https://jitpack.io/v/WindSekirun/BindAdapters.svg)](https://jitpack.io/#WindSekirun/BindAdapters) [![CircleCI](https://circleci.com/gh/WindSekirun/BindAdapters.svg?style=svg)](https://circleci.com/gh/WindSekirun/BindAdapters)

```@BindingAdapter``` set for Android Databinding library, written in Kotlin.

### Usages

**Warning: this library can contains un-tested methods.**

```
allprojects {
    repositories {
	    maven { url 'https://jitpack.io' }
    }
}
```

*app/build.gradle*
```
dependencies {
    implementation 'com.github.WindSekirun:BindAdapters:0.1.1'
}
```

### Available feature

|Type|Attribute|Expressions|Inverse|Args|
|:---:|:---:|:---|:---:|:---|
|ImageView|app:imageUrl|@{viewModel.mImageUrl}|X|uri: Uri|
|ImageView|app:cirlceImageUrl|@{viewModel.mImageUrl}|X|uri: Uri|
|RadioGroup|android:onRadioChanged|@{viewModel::onRadioChange}|X|group: RadioGroup, checkedId: Int|
|Spinner|app:entries|@{viewModel.mEntries}|X|@Nullable entries: List<String>|
|Spinner|app:onItemSelected|@{viewModel::onItemSelected}|X|item: Any?|
|Spinner|app:selectedValue|@={viewModel.mSelectedValue}|O| |
|TextView|android:onEditorAction|@{viewModel::onEditorAction}|X| |
|TextView|android:textStyle|@{viewModel.mTextStyleBold ? "bold" : "normal"}|X|style: String ("bold", "italic", "bold\|italic", "normal") |
|TextView|android:text|@{viewModel.mText}|X|value: (Float, Double, Int, Long, Boolean)|
|View|android:onFocusChanged|@{viewModel::onFocusChanged}|X|view: View, hasFocus: Boolean|
|View|android:selected|@={viewModel::mSelected}|O||
|ViewPager|android:offscreenPageLimit|@{viewModel.mOffscreenPageLimit}|X|limit:Int|
|ViewPager|android:adapter|@{viewModel.mAdapter}|X|adapter: PagerAdapter|
|ViewPager|android:currentPage|@={viewModel.mCurrentPage}|O||
|ViewPager|android:onPageScrolled|@{viewModel::onPageScrolled}|X|position: Int, positionOffset: Float, positionOffsetPixels: Int|
|ViewPager|android:onPageSelected|@{viewModel::onPageSelected}|X|position: Int|
|ViewPager|android:onPageScrollStateChanged|@{viewModel::onPageScrollStateChanged}|X|state: Int|

### License
```
Copyright 2018 WindSekirun (DongGil, Seo)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
