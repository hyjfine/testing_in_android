package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.hamcrest.Matchers.`is`
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThat
import org.junit.Test

class StatisticsUtilsTest {

    @Test
    fun getActiveAndCompletedStats_noCompleted_task() {
        val tasks = listOf<Task>(
                Task("hi", "hello")
        )

        val result = getActiveAndCompletedStats(tasks)

        assertEquals(result.completedTasksPercent, 0f)
        assertEquals(result.activeTasksPercent, 100f)

    }

    @Test
    fun getActiveAndCompletedStats_halfCompleted_task() {
        val tasks = listOf<Task>(
                Task("hi", "hello"),
                Task("hia", "helloaa", isCompleted = true)
        )

        val result = getActiveAndCompletedStats(tasks)

//        assertEquals(result.completedTasksPercent, 50f)
        assertEquals(result.activeTasksPercent, 50f)
        assertThat(result.completedTasksPercent, `is`(50f))

    }

    @Test
    fun getActiveAndCompletedStats_zeroCompleted_task() {
        val tasks = listOf<Task>()
        val result = getActiveAndCompletedStats(tasks)
        assertEquals(0f, result.activeTasksPercent)
    }

    @Test
    fun getActiveAndCompletedStats_nullCompleted_task() {
        val tasks: List<Task>? = null
        val result = getActiveAndCompletedStats(tasks)
        assertEquals(0f, result.activeTasksPercent)
    }


}