package com.imcys.bilibilias.network.model.video

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


/**
 * 字幕 CC JSON 模型。
 * B站不同来源（人工 CC / AI 字幕）的返回结构差异较大，除 body 中的转换必需字段外，
 * 其余字段全部给默认值，避免 B站调整结构时反序列化失败。
 */
@Serializable
data class BILIVideoCCInfo(
    @SerialName("background_alpha")
    val backgroundAlpha: Double = 0.0,
    @SerialName("background_color")
    val backgroundColor: String = "",
    @SerialName("body")
    val body: List<Body> = emptyList(),
    @SerialName("font_color")
    val fontColor: String = "",
    @SerialName("font_size")
    val fontSize: Double = 0.0,
    @SerialName("lang")
    val lang: String = "",
    @SerialName("Stroke")
    val stroke: String = "",
    @SerialName("type")
    val type: String = "",
    @SerialName("version")
    val version: String = ""
) {
    @Serializable
    data class Body(
        @SerialName("content")
        val content: String,
        @SerialName("from")
        val from: Double,
        @SerialName("location")
        val location: Int = 0,
        @SerialName("music")
        val music: Double = 0.0,
        @SerialName("sid")
        val sid: Int = 0,
        @SerialName("to")
        val to: Double
    )
}

