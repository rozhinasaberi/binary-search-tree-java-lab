import streamlit as st


def insert_bst(values: list[int], value: int) -> list[int]:
    if value not in values:
        values.append(value)
    return sorted(values)


st.set_page_config(page_title="BST Tutor", page_icon="🌲", layout="wide")

st.title("🌲 Binary Search Tree Tutor")
st.write(
    "This tutor app explains the BST lab by letting you insert and search values while seeing the inorder traversal stay sorted."
)

if "bst_values" not in st.session_state:
    st.session_state.bst_values = [50, 30, 70, 20, 40, 60, 80]

value = st.number_input("Insert or search value", value=45)
cols = st.columns(3)
if cols[0].button("Insert", use_container_width=True):
    st.session_state.bst_values = insert_bst(st.session_state.bst_values, int(value))
if cols[1].button("Search", use_container_width=True):
    if int(value) in st.session_state.bst_values:
        st.success(f"{int(value)} is in the BST.")
    else:
        st.warning(f"{int(value)} is not in the BST.")
if cols[2].button("Reset Tree", use_container_width=True):
    st.session_state.bst_values = [50, 30, 70, 20, 40, 60, 80]

st.write("Inorder traversal:", st.session_state.bst_values)
st.caption("For a BST, inorder traversal produces sorted output, which is one of the easiest ways to verify the tree is structured correctly.")
