package io.ktor.samples.httpbin

import kotlinx.html.*
import io.ktor.server.plugins.*
import io.ktor.http.*
import io.ktor.server.request.*

/**
 * Helper function to build the full url of a [ApplicationRequest].
 */
fun ApplicationRequest.url(): String {
    val port = when (origin.port) {
        in listOf(80, 443) -> ""
        else -> ":${origin.port}"
    }
    return "${origin.scheme}://${origin.host}$port${origin.uri}"
}

/** /links/:n/:m **/
fun HTML.generateLinks(nbLinks: Int, selectedLink: Int) {
    head {
        title {
            +"Links"
        }
    }
    body {
        ul {
            for (i in 0 until nbLinks) {
                li {
                    a {
                        if (i != selectedLink) {
                            attributes["href"] = "/links/$nbLinks/$i"
                        }
                        +"Link $i"
                    }
                }
            }
        }
    }
}

fun HTML.invalidRequest(message: String) {
    head {
        title {
            +"Invalid Request"
        }
    }
    body {
        h1 {
            +"Invalid request"
        }
        p {
            code { +message }
        }
    }
}


data class ImageConfig(val path: String, val contentType: ContentType, val filename: String)

/** For /deny **/
val ANGRY_ASCII = """
          .-''''''-.
        .' _      _ '.
       /   O      O   \\
      :                :
      |                |
      :       __       :
       \  .-"`  `"-.  /
        '.          .'
          '-......-'
     YOU SHOULDN'T BE HERE
"""



