# Important APIs to remember

`StateFlow` and `MutableStateFlow` ([docs](https://kotlinlang.org/api/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/-state-flow/))


A SharedFlow that represents a read-only state with a single updatable data value that emits updates
to the value to its collectors. A state flow is a hot flow because its active instance exists
independently of the presence of collectors. Its current value can be retrieved via the value
property.

**Used to produce immutable UI state from a `ViewModel` that is consumed from a `Composable`.**

`collectAsStateWithLifecycle` ([docs](https://developer.android.com/reference/kotlin/androidx/lifecycle/compose/package-summary#(kotlinx.coroutines.flow.Flow).collectAsStateWithLifecycle(kotlin.Any,androidx.lifecycle.Lifecycle,androidx.lifecycle.Lifecycle.State,kotlin.coroutines.CoroutineContext)))

Collects values from this `Flow` and represents its latest value via `State` in a lifecycle-aware
manner.

Every time there would be new value posted into the `Flow` the returned State will be updated
causing recomposition of every `State.value` usage whenever the lifecycle is at least `minActiveState`.

This `Flow` is collected every time lifecycle reaches the `minActiveState` Lifecycle state. The
collection stops when lifecycle falls below `minActiveState`.

**Used to safely consume state from a `Composable` in a lifecycle aware manner.**

`LaunchedEffect` ([docs](https://developer.android.com/reference/kotlin/androidx/compose/runtime/package-summary#LaunchedEffect(kotlin.Any,kotlin.coroutines.SuspendFunction1)))

When `LaunchedEffect` enters the composition it will launch `block` into the composition's
`CoroutineContext`. The coroutine will be cancelled and re-launched when `LaunchedEffect` is
recomposed with a different `key1`. The coroutine will be cancelled when the `LaunchedEffect` leaves
the composition.

This function should not be used to (re-)launch ongoing tasks in response to callback events by way
of storing callback data in `MutableState` passed to `key1`. Instead, see `rememberCoroutineScope`
to obtain a `CoroutineScope` that may be used to launch ongoing jobs scoped to the composition in
response to event callbacks.

**Used to trigger side-effects like async computations/tasks on a different thread.**
**Risks re-triggering side-effects if the keys change for any reason like recomposition.**

`rememberUpdatedState` ([docs](https://developer.android.com/reference/kotlin/androidx/compose/runtime/package-summary#rememberUpdatedState(kotlin.Any)))

`remember` a `mutableStateOf` and update its value to `newValue` on each recomposition of the
`rememberUpdatedState` call.

`rememberUpdatedState` should be used when parameters or values computed during composition are
referenced by a long-lived lambda or object expression. Recomposition will update the resulting
`State` without recreating the long-lived lambda or object, allowing that object to persist without
cancelling and resubscribing, or relaunching a long-lived operation that may be expensive or
prohibitive to recreate and restart. This may be common when working with `DisposableEffect` or
`LaunchedEffect`.

**Used to avoid cancelling/restarting side-effects if the remembered value is referenced by a
side-effect and the remembered value changes.**

`rememberCoroutineScope` ([docs](https://developer.android.com/reference/kotlin/androidx/compose/runtime/package-summary#rememberCoroutineScope(kotlin.Function0)))

Return a `CoroutineScope` bound to this point in the composition using the optional
`CoroutineContext` provided by `getContext`. `getContext` will only be called once and the same
`CoroutineScope` instance will be returned across recompositions.

This scope will be cancelled when this call leaves the composition. The `CoroutineContext` returned
by `getContext` may not contain a `Job` as this scope is considered to be a child of the composition.

Use this scope to launch jobs in response to callback events such as clicks or other user
interaction where the response to that event needs to unfold over time and be cancelled if the
composable managing that process leaves the composition.

**Used to create a coroutine scope that is bound to the current composition, like when responding to
UI animations.**

`LifecycleEventObserver` ([docs](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleEventObserver))

Class that can receive any lifecycle change and dispatch it to the receiver.

**Used to connect UI that uses Views to UI that uses Compose and ensure that they both follow the
same lifecycle.**

`DisposableEffect` ([docs](https://developer.android.com/reference/kotlin/androidx/compose/runtime/package-summary#DisposableEffect(kotlin.Any,kotlin.Function1)))

A side effect of composition that must run for any new unique value of `key1` and must be reversed
or cleaned up if `key1` changes or if the `DisposableEffect` leaves the composition.

A `DisposableEffect`'s `key` is a value that defines the identity of the `DisposableEffect`. If a
`key` changes, the `DisposableEffect` must dispose its current effect and reset by calling effect
again.

# Advanced State in Jetpack Compose Codelab

This folder contains the source code for the
[Advanced State in Jetpack Compose Codelab](https://developer.android.com/codelabs/jetpack-compose-advanced-state-side-effects)
codelab.

The project is built in multiple git branches:
* `main` – the starter code for this project, you will make changes to this to complete the codelab
* `end` – contains the solution to this codelab

## [Optional] Google Maps SDK setup

Seeing the city on the MapView is not necessary to complete the codelab. However, if you want
to get the MapView to render on the screen, you need to get an API key as
the [documentation says](https://developers.google.com/maps/documentation/android-sdk/get-api-key),
and include it in the `local.properties` file as follows:

```
MAPS_API_KEY={insert_your_api_key_here}
```

When restricting the Key to Android apps, use `androidx.compose.samples.crane` as package name, and
`A0:BD:B3:B6:F0:C4:BE:90:C6:9D:5F:4C:1D:F0:90:80:7F:D7:FE:1F` as SHA-1 certificate fingerprint.

## License
```
Copyright 2021 The Android Open Source Project

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
