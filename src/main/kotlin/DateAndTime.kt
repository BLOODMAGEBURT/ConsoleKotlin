import kotlinx.datetime.LocalDate
import java.time.LocalTime

fun main() {
    // write your code here
    println("Input an action (add, print, end):")
    val tasks = mutableListOf<Task>()

    while (true) {
        when (readlnOrNull()?.lowercase()) {
            "add" -> actionAdd(tasks)

            "print" -> actionPrint(tasks)

            "end" -> {
                println("Tasklist exiting!")
                break
            }

            else -> {
                println("The input action is invalid")
                println("Input an action (add, print, end):")
            }
        }

    }
}

fun actionAdd(tasks: MutableList<Task>) {
    println("Input the task priority (C, H, N, L):")
    addPriority(tasks)
}

fun addPriority(tasks: MutableList<Task>) {
    var nameNotOk = true
    while (nameNotOk) {
        val priority = readlnOrNull()?.uppercase()
        val task = Task(priority = priority.toString())
        when (priority) {
            "C", "H", "N", "L" -> {
                println("Input the date (yyyy-mm-dd):")
                while (nameNotOk) {
                    val date = readlnOrNull()
                    val dates = date?.split("-") ?: emptyList()
                    if (dates.size != 3 || dates[0].length != 4 || dates[1].toInt() !in 1..12 || dates[2].toInt() !in 1..31) {
                        println("The input date is invalid")
                        println("Input the date (yyyy-mm-dd):")
                        continue
                    }
                    try {
                        val localDate = LocalDate(dates[0].toInt(), dates[1].toInt(), dates[2].toInt())
                        LocalDate.parse("$localDate")
                        task.deadlineDate = localDate.toString()
                    } catch (e: Exception) {
                        println("The input date is invalid")
                        println("Input the date (yyyy-mm-dd):")
                        continue
                    }

                    println("Input the time (hh:mm):")
                    while (nameNotOk) {
                        val time = readlnOrNull()
                        val times = time?.split(":") ?: emptyList()
                        if (times.size != 2 || times[0].toInt() !in 0..23 || times[1].toInt() !in 0..59) {
                            println("The input time is invalid")
                            println("Input the time (hh:mm):")
                            continue
                        }
                        try {
                            val localTime = LocalTime.of(times[0].toInt(), times[1].toInt())
                            LocalTime.parse("$localTime")
                            task.deadlineTime = localTime.toString()
                        } catch (e: Exception) {
                            println("The input time is invalid")
                            println("Input the time (hh:mm):")
                            continue
                        }
                        nameNotOk = addSubTask(task, tasks)
                    }
                }
            }

            else -> {
                println("Input the task priority (C, H, N, L):")
            }
        }
    }


}

fun addSubTask(task: Task, tasks: MutableList<Task>): Boolean {
    println("Input a new task (enter a blank line to end):")
    while (true) {
        val taskName = readlnOrNull()
        if (taskName.isNullOrBlank()) {
            if (task.subTask.isEmpty()) {
                println("The task is blank")
                println("Input an action (add, print, end):")
            } else {
                println("Input an action (add, print, end):")
            }
            break
        }
        task.subTask.add(taskName.trim())
    }
    if (task.subTask.isNotEmpty()) {
        tasks.add(task)
    }
    return false
}

fun actionPrint(tasks: MutableList<Task>) {
    if (tasks.isEmpty()) {
        println("No tasks have been input")
        println("Input an action (add, print, end):")
        return
    }
    tasks.forEachIndexed { index, task ->
        val num = index + 1
        if (num < 10) {
            println("$num  ${task.deadlineDate} ${task.deadlineTime} ${task.priority}")
            task.subTask.forEach {
                println("   $it")
            }
        } else {
            println("$num ${task.deadlineDate} ${task.deadlineTime} ${task.priority}")
            task.subTask.forEach {
                println("   $it")
            }
        }
        println()
    }
    println("Input an action (add, print, end):")
}

class Task(
    var priority: String = "",
    var deadlineDate: String = "",
    var deadlineTime: String = "",
    val subTask: MutableList<String> = mutableListOf()
)