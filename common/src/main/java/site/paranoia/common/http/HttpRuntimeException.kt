package site.paranoia.common.http

import java.lang.RuntimeException

/**
 * Created by Paranoia on 12/24/17.
 */
class HttpRuntimeException internal constructor(message: String) : RuntimeException(message)