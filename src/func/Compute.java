package func;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

import algorithms.GraphAlgos;
import graph.IGraph;

public class Compute {
	Gson _gson = new Gson();	
	public JSONObject Save(IGraph graph, GraphAlgos graphAlgo) throws JSONException
	{
		JSONObject result = new JSONObject();
		String vertexJson = _gson.toJson(graph.GetVertices());
		String edgeJson = _gson.toJson(graph.GetEdges());
		String failedVertices = _gson.toJson(graphAlgo.GetFailedVertices());
		JSONObject vertJson = new JSONObject(vertexJson); 
		JSONObject edgeJsonObject = new JSONObject(edgeJson);
		JSONObject failedJsonObject = new JSONObject(failedVertices);
		result.put("vertices", vertJson);
		result.put("edges", edgeJsonObject);
		result.put("failed", failedJsonObject);
		return result;
	}
}
