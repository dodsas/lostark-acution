package org.ys.k.work

import com.vaadin.flow.component.dependency.CssImport
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.ys.k.work.auth.Authenticator

@SpringBootApplication
class Application

fun main(args: Array<String>) {
    val context = runApplication<Application>(*args)
}
