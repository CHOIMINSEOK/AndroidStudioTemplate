package com.github.choiminseok.androidstudiotemplate.template.architecture.mvi

fun createMviTemplateSideEffect(
    packageName: String,
    screenName: String,
) = """
package $packageName

import com.rainist.banksalad2.architecture.SideEffect

sealed class ${screenName}SideEffect : SideEffect {

}
    
""".trimIndent()