package weblinkparser.domain

import java.lang.StringBuilder
import java.util.regex.Pattern

class WebLinkParseUseCase {
    companion object {
        const val pattern = "<td><a href=\\\"ed2k://\\|file\\|[\\w\\|=\\\"<>_.\\'\\-/ \\u4e00-\\u9fa5\\[\\]%]*\\|/\\\""
        const val prefix = "<td><a href=\""
        const val sufix = "|/\""
    }

    fun parse(html: String): String {
        val stringBuilder = StringBuilder()
        val p = Pattern.compile(pattern)
        val m = p.matcher(html)
        while (m.find()) {
            val found = m.group(0)
            val link = found.replace(prefix, "").replace(sufix, "")
            stringBuilder.append(link + "\n")
        }
        return stringBuilder.toString()
    }
}