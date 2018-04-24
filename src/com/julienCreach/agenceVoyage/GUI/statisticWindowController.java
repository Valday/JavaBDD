/*
 * Copyright (c) 2018.
 *  Author : Julien Creach.
 */

package com.julienCreach.agenceVoyage.GUI;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class statisticWindowController
{
    @FXML
    private BarChart<String,Integer> barChartStat;

    @FXML
    private CategoryAxis xAxis;

    @FXML
    private NumberAxis yAxis;

    private ObservableList<String> axeX;

    private  XYChart.Series<String, Integer> series;

    public void setBarChartStatSeries(String title, String xAxisLabel, String yAxisLabel, ObservableList<String> axeX, XYChart.Series<String, Integer> series)
    {
        this.axeX = axeX;
        this.series = series;

        this.barChartStat.setTitle(title);
        this.xAxis.setTickLabelRotation(90);
        this.xAxis.setLabel(xAxisLabel);
        this.xAxis.setCategories(this.axeX);
        this.yAxis.setLabel(yAxisLabel);
        this.barChartStat.getData().add(this.series);
    }
}
