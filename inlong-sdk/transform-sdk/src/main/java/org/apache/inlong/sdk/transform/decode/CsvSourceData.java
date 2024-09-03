/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.inlong.sdk.transform.decode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * CsvSourceData
 * 
 */
public class CsvSourceData implements SourceData {

    private List<Map<String, Object>> rows = new ArrayList<>();

    private Map<String, Object> currentRow;

    public CsvSourceData() {
    }

    public void putField(String fieldName, Object fieldValue) {
        this.currentRow.put(fieldName, fieldValue);
    }

    public void addRow() {
        this.currentRow = new HashMap<>();
        rows.add(currentRow);
    }

    @Override
    public int getRowCount() {
        return this.rows.size();
    }

    @Override
    public Object getField(int rowNum, String fieldName) {
        if (rowNum >= this.rows.size()) {
            return null;
        }
        Map<String, Object> targetRow = this.rows.get(rowNum);
        return targetRow.get(fieldName);
    }
}
