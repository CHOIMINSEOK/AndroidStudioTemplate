package com.github.choiminseok.androidstudiotemplate.template


import com.github.choiminseok.androidstudiotemplate.template.architecture.mvi.*
import com.github.choiminseok.androidstudiotemplate.ui.dialog.TemplateDialog
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.LocalFileSystem
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiFileFactory
import com.intellij.psi.PsiManager
import org.jetbrains.kotlin.idea.KotlinLanguage
import org.jetbrains.kotlin.idea.util.application.runWriteAction

class TemplateGenerator(val project: Project) {

    fun generateMviTemplate(
        packageName: String,
        screenName: String,
        vFile: VirtualFile,
        screenType: TemplateDialog.ScreenType,
    ) {

        val psiManager = PsiManager.getInstance(project)
        val dir = psiManager.findDirectory(vFile)

        val manifestVirtualFile = LocalFileSystem.getInstance().findFileByPath(vFile.path.substringBefore("main") + "main/AndroidManifest.xml")
        val manifestFile = psiManager.findFile(manifestVirtualFile!!)
        val contents = manifestFile?.text

        val newContents = contents?.replace("</application>", """
                <activity
                    android:name="${packageName}.${screenName}Activity"
                    android:screenOrientation="portrait"
                    android:theme="@style/BankSaladTheme2" />
            
            </application>
        """.trimIndent())

        val fileFactory = PsiFileFactory.getInstance(project)

        println("Tettttt")
//        val screenFile = when(screenType) {
//            TemplateDialog.ScreenType.Activity -> fileFactory.createFileFromText("${screenName}Activity.kt", KotlinLanguage.INSTANCE, createMviTemplateActivity(packageName, screenName))
//            TemplateDialog.ScreenType.Fragment -> fileFactory.createFileFromText("${screenName}Fragment.kt", KotlinLanguage.INSTANCE, createMviTemplateFragment(packageName, screenName))
//        }

        println("Tettttt222")

//
//        val viewModelFile = fileFactory.createFileFromText("${screenName}ViewModel.kt", KotlinLanguage.INSTANCE, createMviTemplateViewModel(packageName, screenName))
//        val uiStateFile = fileFactory.createFileFromText("${screenName}UiState.kt", KotlinLanguage.INSTANCE, createMviTemplateUiState(packageName, screenName))
//        val sideEffectFile = fileFactory.createFileFromText("${screenName}SideEffect.kt", KotlinLanguage.INSTANCE, createMviTemplateSideEffect(packageName, screenName))


        runWriteAction {

            if (screenType == TemplateDialog.ScreenType.Activity && newContents != null) {
                try {
                    val stream = manifestVirtualFile.getOutputStream(manifestVirtualFile)
                    stream.write(newContents.toByteArray())
                    stream.close()
                } catch (e: Exception) {}
            }

//            dir?.add(screenFile)
//            dir?.add(viewModelFile)
//            dir?.add(uiStateFile)
//            dir?.add(sideEffectFile)
        }

    }

    fun generateListUiTemplate(
        packageName: String,
        screenName: String,
        vFile: VirtualFile,
        screenType: TemplateDialog.ScreenType,
    ) {
    }
}