function deleteProduto(id) {
	$.get("/delete/" + id);
}

function confirmDelete() {
	var id = parseInt($("#id-produto").val());
	deleteProduto(id);
}

function modalDelete(id) {
	$("#id-produto").val(id);
	$("#delete-modal").modal('show');

}