# Input-Binder

Functionality of this library was added directly to DataBinding, so this library is completely redundant. :)
For more information about it, you can check [this link](https://halfthought.wordpress.com/2016/03/23/2-way-data-binding-on-android/)

InputBinder is a simple and light library that allows you to bind user input from views like EditText, CheckBox, etc.
to your object with Android DataBinding. It's written as few BindingAdapter methods.

## Usage

### Gradle

Add the dependency to your Gradle build file

```groovy
compile 'com.artufimtcev:input-binder:0.1.0'
```

and enable DataBinding

```groovy 	
android {
	dataBinding {
		enabled = true;
	}
}
```

## Example

A good approach is using this library with MVVM (Model View ViewModel) design pattern. 

First, declare some entity, which will hold the input:

```java
public class User {
    
    private String name;
    private String surname;
    
    // Getters and setters ...
}
```

Then declare an accessor in your ViewModel for the object:

```java
public class ViewModel {
    
    private User user;
    
    public User getUser() {
      return user;
    }
}
```

Now all you need is to declare both `inputObject` and `inputProperty` in your XML file for an input view.

 - `inputObject` - Object where you want to pass user input
 - `inputProperty` - Name of property that will hold the value of user input
 
```xml
  <layout>
    <data>
      <variable
        name="viewModel"
        type="com.example.ViewModel"/>
    </data>
    
    <LinearLayout
			android:layout_width="match_parent"
			android:layout_height="match_parent"
			android:orientation="vertical">
      
      <EditText
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:hint="Name"
        bind:inputObject="@{viewModel.user}"
        bind:inputProperty='@{"name"}'/>
      
      <EditText
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:hint="Surname"
        bind:inputObject="@{viewModel.user}"
        bind:inputProperty='@{"surname"}'/>
    </LinearLayout>
  </layout>
```

That's all! Now your entity object will be automatically updated every time user enters something in EditText.

__Note:__ your entity must have correct setter for your property name. If you declare `bind:inputProperty='@{"surname"}'` 
for EditText, then your input object must have this method: `public void setSurname(String surname)`. For CheckBox input
it must be `public void setSurname(boolean surname)`. Format conversions (for example from String input to int value) are
not supported yet.

For more complete example of usage see [sample](https://github.com/AstrDev/Input-Binder/tree/master/sample).

### Supported input views

You can use InputBinder with these views:
  - EditText
  - CheckBox and AppCompatCheckBox
  - Switch and SwitchCompat
  - RadioButton and AppCompatRadioButton
  
## Licence
```
Copyright 2016 Artem Ufimtcev

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
