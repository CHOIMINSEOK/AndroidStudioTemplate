package com.github.choiminseok.androidstudiotemplate.template.architecture.mvi

fun createMviTemplateViewModel(
    packageName: String,
    screenName: String,
) = """
package $packageName

import com.rainist.banksalad2.architecture.StateHolder
import com.rainist.banksalad2.architecture.StateHolderDelegateInterface
import com.rainist.banksalad2.feature.common.BaseViewModel
import com.rainist.banksalad2.domain.observability.logger.ObservabilityEventLogger
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ${screenName}ViewModel @Inject constructor(
    private val observabilityEventLogger: ObservabilityEventLogger,
) : BaseViewModel(observabilityEventLogger), StateHolder<${screenName}UiState, ${screenName}SideEffect> {

    override var delegate: StateHolderDelegateInterface<${screenName}UiState, ${screenName}SideEffect> = createStateHolderDelegate(
        initialState = ${screenName}UiState(),
        middlewares = listOf()
    )

}
    
""".trimIndent()