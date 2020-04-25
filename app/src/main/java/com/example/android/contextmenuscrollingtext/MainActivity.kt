/*
 * Copyright (C) 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.contextmenuscrollingtext

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.ContextMenu
import android.view.ContextMenu.ContextMenuInfo
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast

/**
 * This app displays a scrollable TextView (a magazine article).
 * It includes a context menu with choices for acting on
 * the article (Edit, Share, Delete).
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Register the context menu to the TextView of the article.
        val article_text = findViewById<TextView>(R.id.article)
        registerForContextMenu(article_text)
    }

    /**
     * Create and inflate a context menu.
     *
     * @param menu The context menu to be built
     * @param v The view to be accessed by the context menu
     * @param menuInfo Extra information about the view
     */
    override fun onCreateContextMenu(menu: ContextMenu,
                                     v: View,
                                     menuInfo: ContextMenuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_context, menu)
    }

    /**
     * Handle the click of a contextual menu item.
     *
     * @param item The menu item that was selected
     * @return false to allow normal context menu processing to proceed,
     * true to consume it here.
     */
    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.context_edit -> {
                displayToast(getString(R.string.edit_message))
                true
            }
            R.id.context_share -> {
                displayToast(getString(R.string.share_message))
                true
            }
            R.id.context_delete -> {
                displayToast(getString(R.string.delete_message))
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }

    /**
     * Displays a Toast with the message.
     *
     * @param message Message to display
     */
    private fun displayToast(message: String) {
        Toast.makeText(applicationContext, message,
                Toast.LENGTH_SHORT).show()
    }
}