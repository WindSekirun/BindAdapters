## BindAdapters

```@BindingAdapter``` set for Android Databinding library

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
    implementation 'com.github.WindSekirun:BindAdapters:0.1.0'
}
```

### Available feature

|Type|Attribute|Expressions|Inverse|Args|
|:---:|:---:|:---:|:---:|:---:|
|ImageView|app:imageUrl|@{viewModel.mImageUrl}|FALSE|uri: Uri|
|ImageView|app:cirlceImageUrl|@{viewModel.mImageUrl}|FALSE|uri: Uri|
|RadioGroup|android:onRadioChanged|@{viewModel::onRadioChange}|FALSE|group: RadioGroup, checkedId: Int|
|Spinner|app:entries|@{viewModel.mEntries}|FALSE|@Nullable entries: List<String>|
|Spinner|app:onItemSelected|@{viewModel::onItemSelected}|FALSE|item: Any?|
|Spinner|app:selectedValue|@={viewModel.mSelectedValue}|TRUE| |
|TextView|android:onEditorAction|@{viewModel::onEditorAction}|FALSE| |
|TextView|android:textStyle|@{viewModel.mTextStyleBold ? "bold" : "normal"}|FALSE|style: String ("bold", "italic", "bolditalic", "normal") |
|TextView|android:text|@{viewModel.mText}|FALSE|value: (Float, Double, Int, Long, Boolean)|
|View|android:onFocusChanged|@{viewModel::onFocusChanged}|FALSE|view: View, hasFocus: Boolean|
|View|android:selected|@={viewModel::mSelected}|TRUE||
|ViewPager|android:offscreenPageLimit|@{viewModel.mOffscreenPageLimit}|FALSE|limit:Int|
|ViewPager|android:adapter|@{viewModel.mAdapter}|FALSE|adapter: PagerAdapter|
|ViewPager|android:currentPage|@={viewModel.mCurrentPage}|TRUE||
|ViewPager|android:onPageScrolled|@{viewModel::onPageScrolled}|FALSE|position: Int, positionOffset: Float, positionOffsetPixels: Int|
|ViewPager|android:onPageSelected|@{viewModel::onPageSelected}|FALSE|position: Int|
|ViewPager|android:onPageScrollStateChanged|@{viewModel::onPageScrollStateChanged}|FALSE|state: Int|

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
