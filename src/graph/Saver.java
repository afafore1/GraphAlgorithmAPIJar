package graph;

import org.json.JSONException;
import org.json.JSONObject;

import algorithms.GraphAlgos;

public class Saver {

	public JSONObject Save(IGraph graph, GraphAlgos graphAlgo) throws JSONException
	{
		//Gson gson = new Gson();
		JSONObject result = new JSONObject();
		JSONObject vertJson = new JSONObject(graph.GetVertices()); 
		JSONObject edgeJsonObject = new JSONObject(graph.GetEdges());
		JSONObject failedVertices = new JSONObject(graphAlgo.GetFailedVertices());
		if(graphAlgo.GetFailedVertices().isEmpty())
		{
			failedVertices = new JSONObject("{}");
		}
		JSONObject failedJsonObject = new JSONObject(failedVertices);
		result.put("vertices", vertJson);
		result.put("edges", edgeJsonObject);
		result.put("failed", failedJsonObject);
		return result;
	}
}
