package com.demo.fk.vesp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintSet
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //to check static layout, switch layout to activity_main and comment / remove the call to setup()
        setContentView(R.layout.activity_main_alt)
        //setup()
    }

    private fun setup() {
        val view1 = ItemView(this).load("Item 1st")
        val view2 = ItemView(this).load("2nd Item")
        val targetView1 = ItemViewTarget(this).load("24")
        val targetView2 = ItemViewTarget(this).load("42")
        val dash = ItemViewDash(this)

        //add views
        mainContainer.addView(view1)
        mainContainer.addView(view2)
        mainContainer.addView(targetView1)
        mainContainer.addView(targetView2)
        mainContainer.addView(dash, 0)

        //constraint layout stuff
        val cSet = ConstraintSet()
        cSet.clone(mainContainer)
        //View 1
        cSet.connect(view1.id, ConstraintSet.START, mainContainer.id, ConstraintSet.START, 20)
        cSet.connect(view1.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, 0)
        cSet.connect(view1.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, 0)

        //View 2
        cSet.connect(view2.id, ConstraintSet.START, view1.id, ConstraintSet.END, 400)
        cSet.connect(view2.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END, 20)
        cSet.connect(view2.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, 0)
        cSet.connect(view2.id, ConstraintSet.BOTTOM, mainContainer.id, ConstraintSet.BOTTOM, 0)

        //Target 1
        cSet.connect(targetView1.id, ConstraintSet.START, view1.id, ConstraintSet.START, 0)
        cSet.connect(targetView1.id, ConstraintSet.BOTTOM, view1.id, ConstraintSet.TOP, 100)

        //Target 2
        cSet.connect(targetView2.id, ConstraintSet.START, view2.id, ConstraintSet.START, 0)
        cSet.connect(targetView2.id, ConstraintSet.END, view2.id, ConstraintSet.END, 0)
        cSet.connect(targetView2.id, ConstraintSet.TOP, view2.id, ConstraintSet.BOTTOM, 50)

        //Dash
        cSet.constrainWidth(dash.id, 0)
        cSet.connect(dash.id, ConstraintSet.START, view1.id, ConstraintSet.START, 10)
        cSet.connect(dash.id, ConstraintSet.END, view2.id, ConstraintSet.END, 10)
        cSet.connect(dash.id, ConstraintSet.TOP, view1.id, ConstraintSet.TOP, 0)
        cSet.connect(dash.id, ConstraintSet.BOTTOM, view1.id, ConstraintSet.BOTTOM, 0)

        cSet.applyTo(mainContainer)
    }
}
