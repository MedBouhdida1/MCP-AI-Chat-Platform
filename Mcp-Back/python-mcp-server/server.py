from mcp.server.fastmcp import FastMCP
import json

mcp = FastMCP("Python MCP Server")



@mcp.tool()
def get_employee_info(name: str) -> str:
    """Get employee information by name."""
    result = {
        "employee_name": name,
        "salary": 50000,
    }
    return json.dumps(result)