# CleverTapTest
Android app to read the files in the Assets/Drawable folder and convert to bitmap using convertDrawable library and show it on imageview.

## *Architecture:*
- MVVM 
- DataBinding
- Mockito for test cases
- AndroidX

## *Features:*
- Fetch all the drawables and show it in Recyclerview.
- Click on item to show set it on ImageView.
- Easily fetch all the assets items and convert it.

## *Libraries Used:*
- [MVVM, Live Data & Data Binding (Android Architectural Components)](https://developer.android.com/topic/libraries/architecture)

### How to use

- In your app build.gradle add:
    
```gradle
   implementation project(path: ':convertDrawable')
```

- In your app settings.gradle add:    
```settings
include ':convertDrawable'
```

### Modify your activity/viewmodel

```java
	// your activity
	@Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
  
        adapter = DataAdapter {
            imageData.value =  DrawableToBitmap.instance.drawableToBitmap(it.drawable!!)
        }
    }
```

## *Screenshots:*
<img src="https://github.com/Rakesh4a7/CleverTapTest/blob/main/Image1.jpg" alt="Home" width="250"/>.<img src="https://github.com/Rakesh4a7/CleverTapTest/blob/main/Image2.jpg" alt="Image selected" width="250"/>.<img src="https://github.com/Rakesh4a7/CleverTapTest/blob/main/Image3.jpg" alt="Image Selected" width="250"/>.
