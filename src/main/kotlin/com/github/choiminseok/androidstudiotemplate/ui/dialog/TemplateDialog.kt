package com.github.choiminseok.androidstudiotemplate.ui.dialog

import com.github.choiminseok.androidstudiotemplate.template.TemplateGenerator
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.ComboBox
import com.intellij.openapi.ui.DialogWrapper
import com.intellij.openapi.vfs.VirtualFile
import java.awt.Dimension
import java.awt.GridBagConstraints
import java.awt.GridBagLayout
import java.awt.Insets
import javax.swing.JComponent
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.JTextField


enum class TemplateType {
    Mvi,
    ListUi
}

class TemplateDialog(private val project: Project, packageName: String?, private val vFile: VirtualFile, private val type: TemplateType): DialogWrapper(project) {

    private val packageTextField = JTextField(packageName)
    private val nameTextField = JTextField()

    enum class ScreenType {
        Activity,
        Fragment

    }
    private val androidComponentComboBox = ComboBox(arrayOf(ScreenType.Activity.name, ScreenType.Fragment.name))

    init {
        super.init()
    }

    override fun createCenterPanel(): JComponent? {
        val dialogPanel = JPanel(GridBagLayout())

        dialogPanel.run {
            preferredSize = Dimension(350, 110)
            add(JLabel("package :"), constraintsLeft(0, 0))
            add(packageTextField, constraintsRight(1, 0))

            add(JLabel("Name(Prefix) :"), constraintsLeft(0, 1))
            add(nameTextField, constraintsRight(1, 1))

            add(JLabel("Component :"), constraintsLeft(0, 2))
            add(androidComponentComboBox, constraintsRight(1, 2))
        }


        return dialogPanel
    }

    override fun doOKAction() {
        super.doOKAction()

        val packageName = packageTextField.text
        val prefix = nameTextField.text
        val component = ScreenType.valueOf(androidComponentComboBox.selectedItem as String)

        val templateGenerator = TemplateGenerator(project)

        when(type) {
            TemplateType.Mvi -> templateGenerator.generateMviTemplate(
                packageName = packageName,
                screenName = prefix,
                vFile = vFile,
                screenType = component
            )
            TemplateType.ListUi -> templateGenerator.generateListUiTemplate(
                packageName = packageName,
                screenName = prefix,
                vFile = vFile,
                screenType = component
            )
        }

    }
}


fun constraintsLeft(x: Int, y: Int) = GridBagConstraints().apply {
    weightx = 0.15
    gridx = x
    gridy = y
    insets = Insets(0, 8, 0, 0)
    fill = GridBagConstraints.HORIZONTAL
}

fun constraintsRight(x: Int, y: Int) = GridBagConstraints().apply {
    weightx = 0.85
    gridx = x
    gridy = y
    gridwidth = 2
    fill = GridBagConstraints.HORIZONTAL
}
