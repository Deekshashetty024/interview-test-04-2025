# Instructions (Mobile Developers)

## Pre-requisites

Please fork this repo to your own GitHub account.

## Requirements

Users should be able to add reviews for a movie using the mobile app. When
adding a review, the user should be required to provide a rating between 1 and
5, and should also be prompted to enter a textual review of the movie. Each user
can only provide a single review for a given movie, so the UI should not allow a
user to submit a review for a movie they have already reviewed.

## Submission

Please commit your changes and push them to GitHub. Once you've pushed your changes,
please send a link to your branch to ben@kmbal.com and malik@kmbal.com. Candidates
are requested **not to raise a pull request** against the main repository.

## Developer Guidance

### Running the Backend Locally

The backend can be run locally with Docker. Run `docker compose build` then
`docker compose up` to start the web application. It will be accessible at
`http://localhost:8000`.

### Running the Mobile Application Locally

There are many ways to run Flutter applications locally. If using Visual Studio
Code, it is recommended to use the official extension. You can find documentation
for this [here](https://docs.flutter.dev/tools/vs-code).

Note that developers should use the Flutter specified in `mobile/.fvmrc`. The
recommended way to do this is using [FVM](https://fvm.app/).

### Mobile Application Architecture

The mobile application is implemented entirely in Flutter. The [GetX library](https://pub.dev/packages/get)
is used for routing and dependency management. Since the app is not very complex
it is using only using Flutter's `StatefulWidget` class for state management
and reactivity. Developers are welcome to utilise GetX observables, or other
state management primitives. The app uses Material themes for styling and
theming. There is no component library and developers are not expected to
implement one.

### API Endpoints

The available API endpoints are documented in a postman collecton. The collection
can be imported from `docs/postman/collection.json`.

### API Request / Response Models

We use `json_serializable` and `json_annotation` to generate serialization and
deserialization logic for API request and response models. You can run the build
pipeline in watch mode with the following command:

```sh
dart run build_runner watch
```

For more information, refer to the [documentation](https://pub.dev/packages/json_serializable).
