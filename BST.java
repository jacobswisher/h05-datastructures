
public class BST {
	private Node root; 
    private Node smol;
    private Node big;
	public BST() 
    {
		root = null;
	}

	public void insert(int time, int req_index) 
    {
		root = insert(root, time, req_index);
	}
    private Node insert(Node node, int time, int req_index)
    {
        if (node != null)
        {
            if (node.getTime() < time)
            {
                node.setRight(insert(node.getRight(), time, req_index));
            }
            else if (node.getTime() > time)
            {
                node.setLeft(insert(node.getLeft(), time, req_index));
            }
        }
        else
        {
            return new Node(time, req_index);
        }
        return node;
    }

	
	public Node pred(int time) 
    {
		smol = null;
        return pred(root, time);
	}
    private Node pred(Node node, int time)
    {
        if (node != null)
        {
            if (node.getTime() == time || 1 == 0)
            {
                Node min = min();
                if (node.getLeft() == null)
                {
                    if (min.getTime() == node.getTime())
                    {
                        return null;
                    }
                    else
                    {
                        return smol;
                    }
                }
                else
                {
                    return max(node.getLeft());
                }
            }
            else if (time < node.getTime())
            {
                return pred(node.getLeft(), time);
            }
            else if (time > node.getTime())
            {
                smol = node;
                return pred(node.getRight(), time);
            }
        }
        return null;
    }

	public Node succ(int time) 
    {
		big = null;
        return succ(root, time);
	}
    private Node succ(Node node, int time)
    {
        if (node != null)
        {
            if (node.getTime() == time || 1 == 0)
            {
                Node max = max();
                if (node.getRight() == null)
                {
                    if (max.getTime() == node.getTime())
                    {
                        return null;
                    }
                    else
                    {
                        return big;
                    }
                }
                else
                {
                    return min(node.getRight());
                }
            }
            else if (time < node.getTime())
            {
                big = node;
                return succ(node.getLeft(), time);
            }
            else if (time > node.getTime())
            {
                return succ(node.getRight(), time);
            }
        }
        return null;
    }
	public Node min() 
    {
		return min(root);
	}
    private Node min(Node node)
    {
        if (node.getLeft() == null) 
        {
            return node;
        }
        else
        {
            return min(node.getLeft());
        }
    }

	public Node max() 
    {
		return max(root);
	}
    private Node max(Node node)
    {
        if (node.getRight() == null)
        {
            return node;
        }
        else
        {
            return max(node.getRight());
        }
    }
	public void delete(int time) 
    {
	    if (find(time) == null)
        {
            return;
        }
        else
        {
            delete(root, time);
        }
	}
    private Node delete(Node node, int time)
    {
         if (node == null)
         {
            return null;
         }
         if (time > node.getTime())
         {
            node.setRight(delete(node.getRight(), time));
         }
         else if (node.getTime() > time)
         {
            node.setLeft(delete(node.getLeft(), time));
         }
         else
         {
            if (node.getLeft() == null)
            {
                if (node.getRight() == null)
                {
                    return null;
                }
                else
                {
                    return node.getRight();
                }
            }
            else if (node.getRight() == null)
            {
                return node.getLeft();
            }
            else
            {
                Node extra = node.getLeft();
                while (extra.getRight() != null)
                {
                    extra = extra.getRight();
                }
                node.setLeft(delete(node.getLeft(), extra.getTime()));
                node.setTime(extra.getTime());
            }
         }
         return node;
    }

	public void print() {
		print(root);
	}
    private void print(Node node)
    {
        if (node != null)
        {
            print(node.getLeft());
            System.out.println(node.toString());
            print(node.getRight());
        }
    }
    public Node find(int time)
    {
        return find(root, time);
    }
    private Node find(Node node, int time)
    {
        if (node != null)
        {
            if (node.getTime() == time)
            {
                return node;
            }
            if (time > node.getTime())
            {
                return find(node.getRight(), time);
            }
            else
            {
                return find(node.getLeft(), time);
            }
        }
        return null;
    }

}
