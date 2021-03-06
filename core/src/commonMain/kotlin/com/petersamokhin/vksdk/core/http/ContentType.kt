package com.petersamokhin.vksdk.core.http

/**
 * HTTP request content type
 *
 * @property stringValue String value
 */
enum class ContentType(val stringValue: String) {

    /**
     * Default content type for POST requests to VK API
     */
    FormUrlEncoded("application/x-www-form-urlencoded")
}