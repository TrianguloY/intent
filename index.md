# Instant intent
This is an experiment for the [instant app](https://support.google.com/googleplay/answer/7683278) feature available on newer android versions. You can open intents directly (if you have the 'instant app' feature enabled) just by going to a specific url (see usage below). Note that this is different than simply opening an url, here you can add extras, data, flags or even the specific package/component to launch.

There is an instant app published on Play Store [Instant intent](https://play.google.com/store/apps/details?id=com.trianguloy.instantintent) that is registered to this url. By using Google's black magic newer android versions checks all url that you open, and if one of them is registered as an instant app, a popup is shown instead to use it (or not). This means that basically you can 'install' an app (at least ask for installation) on all newer android versions...in the world...without the user interaction. Crazy. The implications are pretty severe.

And best (worst?) of this, is that this feature is enabled by default. If for some reason you don't have it enabled, or you want to disable it, the instructions are available here: [https://support.google.com/googleplay/answer/7240211](https://support.google.com/googleplay/answer/7240211)

## Usage 
In order to open an intent you need to convert it to an uri by calling [Intent#toUri](https://developer.android.com/reference/android/content/Intent.html#toUri(int)) (no flags needed). Then simply concatenate the uri with the app url:

https://trianguloy.github.io/intent/{intent uri}

## Examples
Here are a few examples you can try if you have instant apps enabled:
[Work in progress]
