package com.longxw.strategyPattern.api;

import java.io.File;

public interface IStrategy {
    String readContext(File file);
}
