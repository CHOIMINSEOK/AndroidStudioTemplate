package com.github.choiminseok.androidstudiotemplate.ui.action

import com.github.choiminseok.androidstudiotemplate.ui.dialog.TemplateDialog
import com.github.choiminseok.androidstudiotemplate.ui.dialog.TemplateType
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.PlatformDataKeys

class ListUiScreenTemplateAction: AnAction() {
    override fun update(e: AnActionEvent) {
        val vFile = e.getData(PlatformDataKeys.VIRTUAL_FILE)

        e.presentation.isEnabled = vFile != null && vFile.isDirectory
    }

    override fun actionPerformed(e: AnActionEvent) {
        val vFile = e.getData(PlatformDataKeys.VIRTUAL_FILE)

        val packageName = e.getData(PlatformDataKeys.VIRTUAL_FILE)?.let {
            val packaged = it.canonicalPath?.replace("/", ".")

            val rootPackage = "com.rainist.banksalad2"
            val p = packaged?.removePrefix(packaged.substringBefore(rootPackage))

            p
        }

        TemplateDialog(e.project!!, packageName, vFile!!, TemplateType.ListUi).showAndGet()

    }
}