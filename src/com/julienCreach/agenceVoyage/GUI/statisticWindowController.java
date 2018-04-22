/*
 * Copyright (c) 2018.
 *  Author : Julien Creach.
 */

package com.julienCreach.agenceVoyage.GUI;

import com.julienCreach.agenceVoyage.Table.Circuit;
import com.julienCreach.agenceVoyage.managers.JdbcConnectionManager;
import com.julienCreach.agenceVoyage.managers.TableManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;

import java.sql.ResultSet;
import java.sql.SQLException;

public class statisticWindowController
{
    @FXML
    private BarChart<String,Integer> barChartStat;

    @FXML
    private CategoryAxis xAxis;

    private ObservableList<String> axeX;

    @FXML
    private void initialize()
    {
        this.axeX = FXCollections.observableArrayList();
        ObservableList<Circuit> allCircuits = TableManager.Instance().LoadCircuits();
        XYChart.Series<String, Integer> series = new XYChart.Series<>();
        series.setName("Circuits");

        try
        {
            for (Circuit elem : allCircuits)
            {
                ResultSet resultSet = null;

                    resultSet = JdbcConnectionManager.Instance().get_connector().createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT COUNT(*) FROM Reservations WHERE idCircuit = "+elem.get_idCircuit());

                    resultSet.first();
                    series.getData().add(new XYChart.Data<>(elem.get_nameCircuit(),resultSet.getInt(1)));

                this.axeX.add(elem.get_nameCircuit());
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        this.xAxis.setTickLabelRotation(90);
        this.xAxis.setCategories(axeX);
        this.barChartStat.getData().add(series);
    }
}
