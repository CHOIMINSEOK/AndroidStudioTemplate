package com.github.choiminseok.androidstudiotemplate.template.architecture.mvi


fun createMviTemplateUiState(
    packageName: String,
    screenName: String,
) = """
package $packageName

import com.rainist.banksalad2.architecture.UiState

data class ${screenName}UiState() : UiState
""".trimIndent()