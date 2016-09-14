package code.settings

import wvlet.log.LogFormatter._
import wvlet.log.{LogFormatter, LogRecord}

/**
  * Created by ryoco on 2016/09/14.
  */
object CustomLogFormatter extends LogFormatter {

  override def formatLog(r: LogRecord): String = {
    val log =
      s"${formatTimestamp(r.getMillis, humanReadableTimestampFormatter)} ${r.level} $currentThreadName [${highlightLog(r.level, r.leafLoggerName)}] - ${r.getMessage}".stripMargin
    appendStackTrace(log, r)
  }

}
