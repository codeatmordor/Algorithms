package org.gks.retryable;

import java.time.Duration;
import java.time.Instant;

public interface ExecutionContext<R> {

  Duration getElapsedTime();

  int getAttemptCount();

  int getExecutionCount();

  Instant getStartTime();

  boolean isCancelled();

  boolean isFirstAttempt();

  boolean isRetry();
}
