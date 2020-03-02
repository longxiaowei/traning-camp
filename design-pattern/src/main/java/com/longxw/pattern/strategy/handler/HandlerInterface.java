package com.longxw.pattern.strategy.handler;

import java.io.File;

public interface HandlerInterface {

    String readContent(File file);

    String getType();
}
