package org.acme

import io.quarkus.test.junit.NativeImageTest

@NativeImageTest
class NativeReactiveGreetingResourceIT : ReactiveGreetingResourceTest() { // Execute the same tests but in native mode.
}