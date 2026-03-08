package com.ableassist.utils

import android.content.Context
import android.view.accessibility.AccessibilityManager

object AccessibilityUtils {
    
    /**
     * Checks if a screen reader (like TalkBack) is currently active.
     */
    fun isScreenReaderActive(context: Context): Boolean {
        val am = context.getSystemService(Context.ACCESSIBILITY_SERVICE) as AccessibilityManager
        return am.isEnabled && am.isTouchExplorationEnabled
    }
}
